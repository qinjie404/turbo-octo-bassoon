package ${package.Controller};

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


/**
* Controller - ${table.comment!}
* ============================================================================
* 版权所有 ${cfg.year} 。
*
* @author ${author}
* @version 1.0 ${date}
* ============================================================================
*/
@Slf4j
@Controller
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
public class ${table.controllerName} {


}