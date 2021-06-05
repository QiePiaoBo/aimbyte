package com.dylan.learntomcat.MyTomcat;

/**
 * @author Dylan
 * @Date : 2021/6/5 - 20:22
 * @Description :
 * @Function :
 */
public abstract class MyHttpSrevlet {

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    public abstract void doGet(MyRequest request, MyResponse response) throws Exception;

    public abstract void doGPost(MyRequest request, MyResponse response) throws Exception;

    /**
     * 根据请求内容判断调用doGet还是doPost去处理请求
     * @param request
     * @param response
     */
    public void service(MyRequest request, MyResponse response) throws Exception {
        if (METHOD_GET.equals(request.getRequestMethod())){
            doGet(request, response);
        }else if (METHOD_POST.equals(request.getRequestMethod())){
            doGPost(request, response);
        }
    }
}
