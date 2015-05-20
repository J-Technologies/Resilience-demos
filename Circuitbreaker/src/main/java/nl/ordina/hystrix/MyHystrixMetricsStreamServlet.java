package nl.ordina.hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "HystrixMetricsStreamServlet", urlPatterns = "/hystrix.stream" ,loadOnStartup = 1)
public class MyHystrixMetricsStreamServlet extends HystrixMetricsStreamServlet{
}