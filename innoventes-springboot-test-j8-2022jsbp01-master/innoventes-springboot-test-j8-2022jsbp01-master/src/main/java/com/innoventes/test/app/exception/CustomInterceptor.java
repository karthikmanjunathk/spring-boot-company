public class CustomInterceptor implements HandlerInterceptor{

    //unimplemented methods comes here. Define the following method so that it
    //will handle the request before it is passed to the controller.

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler){
        String parameter = request.getParameter("webSiteURL");
        if (request.getMethod() != "POST") {  // HttpStatus.Method.POST can be used.
            return true;       // Not intercepting other methods than post.
        }
        if (!isValid(websiteURL)) {
            request.setAttribute("webSiteURL", null);
        }
        return true;
    }

    public boolean isValid(String websiteURL){
        // Logic for validating the URL
        return true;
    }
}