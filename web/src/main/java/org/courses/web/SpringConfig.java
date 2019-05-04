package org.courses.web;

import org.apache.cxf.bus.spring.SpringBus;
        import org.apache.cxf.jaxws.EndpointImpl;
        import org.courses.data.DAO.DAO;
        import org.courses.domain.hbm.*;
        import org.courses.web.soap.ManufactureService;
        import org.courses.web.soap.MaterialService;
        import org.courses.web.soap.TypeService;
import org.courses.web.soap.SocksService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.*;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;

        import javax.xml.ws.Endpoint;

@EnableWebMvc
@Configuration
@Import(org.courses.data.SpringConfig.class)
@ImportResource("classpath:META-INF/cxf/cxf.xml")
public class SpringConfig {
    @Autowired
    DAO<Type, Integer> typeDao;
    @Autowired
    DAO<Material, Integer> materialDao;
    @Autowired
    DAO<Manufacture, Integer> manufactureDao;
    @Autowired
    DAO<Socks, Integer> socksDao;
    @Autowired
    DAO<Storage,Integer> storageDao;


    @Bean
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    public TypeService TypeService() {
        return new TypeService(typeDao);
    }
    @Bean
    public MaterialService MaterialService() {
        return new MaterialService(materialDao);
    }
    @Bean
    public ManufactureService ManufactureService() {
        return new ManufactureService(manufactureDao);
    }
    @Bean
    public SocksService SocksService() {
        return new SocksService(socksDao);
    }

    @Bean
    public Endpoint ManufactureEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), ManufactureService());
        endpoint.publish("/manufacture");
        return endpoint;
    }

    @Bean
    public Endpoint TypeEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), TypeService());
        endpoint.publish("/type");
        return endpoint;
    }

    @Bean
    public Endpoint MaterialEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), MaterialService());
        endpoint.publish("/material");
        return endpoint;
    }

    @Bean
    public Endpoint SocksEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), SocksService());
        endpoint.publish("/socks");
        return endpoint;
    }

    @Bean
    public org.courses.web.rest.StorageService restSocksService() {
        return new org.courses.web.rest.StorageService(storageDao);
    }

}
