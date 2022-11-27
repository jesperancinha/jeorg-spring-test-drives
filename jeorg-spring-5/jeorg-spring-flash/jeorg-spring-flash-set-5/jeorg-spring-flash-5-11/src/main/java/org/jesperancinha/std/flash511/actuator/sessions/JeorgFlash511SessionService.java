package org.jesperancinha.std.flash511.actuator.sessions;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

@Service
public class JeorgFlash511SessionService {

    private final Map<String, HttpSession> httpSessionMap = new ConcurrentSkipListMap<>();

    public void addSession(HttpSession httpSession) {
        this.httpSessionMap.put(httpSession.getId(), httpSession);
    }

    public void removeSession(HttpSession httpSession) {
        this.httpSessionMap.remove(httpSession.getId());
    }

    public List<HttpSession> getSessions() {
        return new ArrayList<>(httpSessionMap.values());
    }
}