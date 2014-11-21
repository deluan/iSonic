package com.deluan.isonic

import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer
import org.apache.solr.core.CoreContainer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.solr.core.SolrTemplate
import org.springframework.data.solr.repository.config.EnableSolrRepositories

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableSolrRepositories("com.deluan.isonic.repository")
public class ISonicApplication {

    static void main(String[] args) {
        def ctx = SpringApplication.run(ISonicApplication.class, args)

        println("Let's inspect the beans provided by Spring Boot:")

        ctx.beanDefinitionNames.sort().each { beanName ->
            println("   ${beanName}")
        }
    }

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