package ru.stqa.pft.mantis.appmanager;

import javax.swing.text.html.parser.Entity;
import java.io.Closeable;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;
import org.apache.http.impl.client.CloseableHttpClient;



public class HttpSession {
    private CloseableHttpClient httpclient;
    private ApplicationManager app;

    public HttpSession(ApplicationManager app){
        this.app = app;
        httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    //создаётся новая http-сессия будет отправлять запросы на сервер, setRedirectStrategy устанавливается стратегия перенаправлений
    //вызвали конструктор - создан новый объеккт - и помещен в поле httpclient
    }
}


public boolean login(String username, String password) throws IOException {
    //в помощнике реализовано 2 метода
    //этот имеет выполнять логин
    HttpPost post = new HttpPost(app.getProperty("web.baseUrl") + "/login.php");
    //создаём запрос по адресу baseUrl/login.php, создаётся запрос типа POST, тело пустое
    List<NameValuePair> params = new ArrayList<~>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("password", password));
    params.add(new BasicNameValuePair("secure_session", "on"));
    params.add(new BasicNameValuePair("return", "index.php"));
    //добавляе в тело параметры запроса
    post.setEntity(new UrlEncodedFormEntity(params));
    //параметры упаковываются и помещаются в созданный запрос - запрос готов к отправке
    CloseableHttpResponse response = httpclient.execute(post);
    //httpclient.execute(post) происходит отправка запроса, response - резулбтат запроса, ответ от сервера
    String body = geTextForm(response);
    return body.contains(String.format("<span class=\"italic\"%s/span>", username));
    //проверяется есть ли на странице имя поьзователя который вошел в систему
}

private String geTextForm(CloseableHttpResponce responce) throws IOException {
   //получаем текст запроса - html код страницы
    try{
        return EntityUtils.toString(responce.getEntity());
    }finally {
        responce.close();
    }
}

public boolean isLoggedInAs(String username) throws IOException{
    HttpGet get = new HttpGet(app.getProperty("web.baseUrl") + "/index.php");  //создаём GET запрос
    CloseableHttpRasponse response = httpclient.execute(get);  //выполняем(отправляем) запрос, получаем ответ
    String body = geTextForm(response); //получаем текст при помощи вспомогатеьной функции geTextForm()
    return body.contains(String.format("<span class=\"italic\"%s/span>", username)); //проверяем что пользователь залогинен
    //умеет определять какой пользователь сейчас залогинен
}