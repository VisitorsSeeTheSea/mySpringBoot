package weiwei.li.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import weiwei.li.service.HessianService;

/**
 * @author weiwei.li
 * @date 2017/12/27.
 */
@Configuration
public class HessionConfiguration {

    @Autowired
    private HessianService hessianService;
    //发布服务
    @Bean(name = "/HessianService")
    public HessianServiceExporter accountService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(hessianService);
        exporter.setServiceInterface(HessianService.class);
        return exporter;
    }
}
