package com.deluan.isonic.conf

import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer
import org.apache.solr.core.CoreContainer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.solr.core.SolrTemplate
import org.springframework.data.solr.repository.config.EnableSolrRepositories

@Configuration
@ComponentScan
@EnableSolrRepositories("com.deluan.isonic.repository")
class SolrConfiguration {
    @Bean
    public SolrServer solrServer() {
        File solrHome = new File("solr")
        System.setProperty("solr.solr.home", solrHome.absolutePath)
        System.setProperty("solr.data.dir", new File("tmp/solr/data").absolutePath)

        def container = new CoreContainer(solrHome.absolutePath)
        container.load()

        new EmbeddedSolrServer(container, "collection1")
    }

    @Bean
    public SolrTemplate solrTemplate(SolrServer server) throws Exception {
        return new SolrTemplate(server)
    }
}
