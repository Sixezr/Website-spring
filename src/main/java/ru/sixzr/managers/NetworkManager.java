package ru.sixzr.managers;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class NetworkManager {

    public Double getDollarCourse() {
        Request request = new Request.Builder()
                .url("https://currate.ru/api/?get=rates&pairs=USDRUB&key=3b8e8bcf5e2746d745c5fabb1bccacf5")
                .build();
        Call call = new OkHttpClient().newCall(request);

        try {
            Response response = call.execute();
            String responseBody = response.body().string();
            Pattern pattern = Pattern.compile("(?<=\"USDRUB\":)\".+\"");
            Matcher matcher = pattern.matcher(responseBody);
            if (matcher.find()) {
                return Double.parseDouble(matcher.group(0).replace("\"", ""));
            }
        } catch (Exception e) {
            return 0D;
        }
        return 0D;
    }
}
