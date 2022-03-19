package by.tms.configuration;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		registerHiddenFieldFilter(servletContext);
	}

	//добавление фильтра, для _method и будет работать перенаправление запросов
	//работает для всех запросов приложения "/*"
	private void registerHiddenFieldFilter(ServletContext servletContext) {
		servletContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter())
				.addMappingForUrlPatterns(null, true, "/*");
	}
}
