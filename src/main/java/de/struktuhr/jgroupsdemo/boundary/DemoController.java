package de.struktuhr.jgroupsdemo.boundary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.struktuhr.jgroupsdemo.control.JGroupsInfo;

@RestController
public class DemoController {

    private final JGroupsInfo jgroupsInfo;
    
    public DemoController(JGroupsInfo jgroupsInfo) {
        this.jgroupsInfo = jgroupsInfo;
    }

    @GetMapping("/info")
    public String getInfo() {
        return "I am the leader " + jgroupsInfo.isLeader();
    }
}
