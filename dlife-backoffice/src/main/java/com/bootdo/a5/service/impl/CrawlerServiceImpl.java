package com.bootdo.a5.service.impl;

import com.bootdo.a5.dao.ArticleReferralDao;
import com.bootdo.a5.domain.ArticleReferralDO;
import com.bootdo.common.utils.MD5Utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.a5.dao.CrawlerDao;
import com.bootdo.a5.domain.CrawlerDO;
import com.bootdo.a5.service.CrawlerService;


@Service
public class CrawlerServiceImpl implements CrawlerService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CrawlerDao crawlerDao;
    @Autowired
    private ArticleReferralDao articleReferralDao;

    @Override
    public CrawlerDO get(Long id) {
        return crawlerDao.get(id);
    }

    @Override
    public List<CrawlerDO> list(Map<String, Object> map) {
        return crawlerDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return crawlerDao.count(map);
    }

    @Override
    public int save(CrawlerDO crawler) {
        return crawlerDao.save(crawler);
    }

    @Override
    public int update(CrawlerDO crawler) {
        return crawlerDao.update(crawler);
    }

    @Override
    public int remove(Long id) {
        return crawlerDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return crawlerDao.batchRemove(ids);
    }

    @Override
    public int crawling(Long id) {
        int ret = 0;

        CrawlerDO crawlerDO = crawlerDao.get(id);

        Document doc = null;
        try {
//			String url = "http://service.weibo.com/widget/widget_blog.php?uid="+uid;
            String url = crawlerDO.getChannelUrl();
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        if (doc != null) {
//            Elements items = doc.select(".txt-box");
            Elements items = doc.select(crawlerDO.getSymbolParagraph());
            for (Element item : items) {
//				SampleContent content = new SampleContent();
                ArticleReferralDO articleReferralDO = new ArticleReferralDO();
                articleReferralDO.setCrawlerId(crawlerDO.getId());

                String itemTitle = item.select(crawlerDO.getSymbolTitle()).text();
                String itemContent = item.select(crawlerDO.getSymbolSummary()).html();
                String itemUrl = item.select(crawlerDO.getSymbolUrl()).attr("href");

                if (null == itemTitle || null == itemContent || null == itemUrl)
                    continue;


                articleReferralDO.setOriginTitle(itemTitle);
                articleReferralDO.setOriginSummary(itemContent);

//                String itemTime = item.select(".wgtCell_txtBot .wgtCell_tm a").text();
                //TODO 处理时间
//				content.setCreatedDate(null);


                //check if the url already archived

                Map<String, Object> query = new HashMap<>();
                String urlMD5 = MD5Utils.encrypt(itemTitle);
                query.put("originUrlCode", MD5Utils.encrypt(itemTitle));

                boolean existed = articleReferralDao.count(query) > 0;
                if (existed) continue;
                else {
                    articleReferralDO.setOriginUrl(itemUrl);
                    articleReferralDO.setOriginUrlCode(urlMD5);
                    articleReferralDao.save(articleReferralDO);
                    ret++;
                }

            }
        }

        if (ret > 0) {
            crawlerDO.setUpdateDate(new Date());
            crawlerDO.setExecuted(crawlerDO.getExecuted()!=null? crawlerDO.getExecuted() + 1 : 1 );
            crawlerDao.update(crawlerDO);
        }

        return ret;
    }

}
