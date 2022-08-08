package com.paigu.interview.controller;

import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oshi.hardware.HWDiskStore;
import oshi.hardware.NetworkIF;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class MonitorController {
    /**
     * cpu信息
     *
     * @return {@link String}
     */
    @GetMapping("/cpu")
    public Object cpuInfo() {
        CpuInfo cpuInfo = OshiUtil.getCpuInfo();
        log.info("{cpu信息:{}}", cpuInfo);
        return cpuInfo;
    }

    /**
     * 网卡信息
     *
     * @return {@link String}
     */
    @GetMapping("/net")
    public Object netInfo() {
        List<NetworkIF> networkIFs = OshiUtil.getNetworkIFs();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < networkIFs.size(); i++) {
            log.info("网卡{}信息:{}", i, networkIFs.get(i));
        }
        return networkIFs;
    }

    /**
     * 网卡信息
     *
     * @return {@link String}
     */
    @GetMapping("/disk")
    public Object disk() {
        List<HWDiskStore> diskStores = OshiUtil.getDiskStores();
        for (int i = 0; i < diskStores.size(); i++) {
            log.info("硬盘{}信息:{}", i, diskStores.get(i));
        }
        return diskStores;
    }

    @GetMapping("/uuid")
    public String uuid(){
        return OshiUtil.getSystem().getHardwareUUID();
    }
}
