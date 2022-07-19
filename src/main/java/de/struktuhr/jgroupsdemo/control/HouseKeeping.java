package de.struktuhr.jgroupsdemo.control;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HouseKeeping {

    private final JGroupsInfo jGroupsInfo;

    public HouseKeeping(JGroupsInfo jGroupsInfo) {
        this.jGroupsInfo = jGroupsInfo;
    }

    @Scheduled(fixedDelay = 10_000)
    public void run() {
        jGroupsInfo.isLeader();
    }
}
