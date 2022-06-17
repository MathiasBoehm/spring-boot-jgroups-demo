package de.struktuhr.jgroupsdemo.control;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JGroupsInfo {

    private final static Logger log = LoggerFactory.getLogger(JGroupsInfo.class);
    

    @Value("${app.jgroups.config}")
    private String jGroupsConfig;

    @Value("${app.jgroups.cluster}")
    private String clusterName;

    private JChannel channel;

    @PostConstruct
    public void init() {
        log.info("init");
        try {
            channel = new JChannel(jGroupsConfig);
            channel.connect(clusterName);
        } catch (Exception ex) {
            log.error("registering the channel in JMX failed: {}", ex);
        }
    }

    @PreDestroy
    public void close() {
        log.info("close");
        if (channel != null) {
            channel.close();
        }
    }

    public boolean isLeader() {
        boolean isLeader = false;
        Address address = channel.getView().getMembers().get(0);
        if (address.equals(channel.getAddress())) {
            log.info("I'm ({}) the leader", channel.getAddress());
            isLeader = true;
        } 
        else {
            log.info("I'm ({}) not the leader", channel.getAddress());
        }
        return isLeader;
      }
}
