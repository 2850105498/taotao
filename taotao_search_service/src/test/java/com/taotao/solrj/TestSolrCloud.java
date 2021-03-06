package com.taotao.solrj;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * @version V1.0
 * @ClassName:${file_name}
 * @Description:solr集群测试
 * @author:cxg
 * @Date:${time}
 */
public class TestSolrCloud {
    @Test
    public void  testSolrCloudAddDocument()throws Exception{
        //创建一个CloudSolrServer对象，构造方法中需要制定zookeeper的地址列表
        CloudSolrServer cloudSolrServer=new CloudSolrServer("192.168.25.129:2181,192.168.25.129:2182,192.168.25.129:2183");
        //需要设置默认的Collection
        cloudSolrServer.setDefaultCollection("collection2");
        //创建一个文档对象
        SolrInputDocument document=new SolrInputDocument();
        //向文档中添加域
        document.addField("item_title", "测试商品");
        document.addField("item_price", "100");
        document.addField("id", "test001");
        //把文档写入索引库
        cloudSolrServer.add(document);
        //提交
        cloudSolrServer.commit();
    }
}
