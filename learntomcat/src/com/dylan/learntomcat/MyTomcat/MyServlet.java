package com.dylan.learntomcat.MyTomcat;

/**
 * @author Dylan
 * @Date : 2021/6/5 - 20:27
 * @Description :
 * @Function :
 */
public class MyServlet extends MyHttpSrevlet{

    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.write("get myTomcat");
    }

    @Override
    public void doGPost(MyRequest request, MyResponse response) throws Exception {
        response.write("post myTomcat");
    }
}
