package com.tkisor.utiljs.kubejs;

import dev.latvian.mods.kubejs.typings.Info;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OperatingSystem;

import java.lang.management.ManagementFactory;
import java.util.*;

@Info("Provides system OS and hardware information utilities")
public class Os {
    @Info("System-dependent end-of-line string")
    public final String EOL = System.lineSeparator();

    private static final SystemInfo SI = new SystemInfo();
    private static final OperatingSystem OS = SI.getOperatingSystem();
    private static final CentralProcessor PROCESSOR = SI.getHardware().getProcessor();
    private static final GlobalMemory MEMORY = SI.getHardware().getMemory();

    @Info("Operating system platform")
    public String platform() {
        String family = OS.getFamily().toLowerCase(Locale.ROOT);
        if (family.contains("windows")) return "windows";
        if (family.contains("mac") || family.contains("darwin")) return "macos";
        if (family.contains("linux") || family.contains("unix")) return "linux";
        return "unknown";
    }

    @Info("System architecture")
    public String arch() {
        String arch = PROCESSOR.getProcessorIdentifier().getIdentifier();
        if (arch == null || arch.isEmpty()) {
            arch = System.getProperty("os.arch").toLowerCase(Locale.ROOT);
        } else {
            arch = arch.toLowerCase(Locale.ROOT);
        }

        if (arch.contains("intel64") || arch.contains("amd64") || arch.contains("x86_64")) return "x64";
        if (arch.contains("x86")) return "x86";
        if (arch.contains("arm") || arch.contains("aarch64")) return arch.contains("64") ? "arm64" : "arm";

        return arch;
    }

    @Info("CPU core information")
    public List<Map<String, Object>> cpus() {
        long[][] ticks = PROCESSOR.getProcessorCpuLoadTicks();
        long[] freqs = PROCESSOR.getCurrentFreq();
        int logicalCount = PROCESSOR.getLogicalProcessorCount();
        String model = PROCESSOR.getProcessorIdentifier().getName();

        List<Map<String, Object>> result = new ArrayList<>(logicalCount);
        for (int i = 0; i < logicalCount; i++) {
            Map<String, Object> core = new LinkedHashMap<>();
            core.put("model", model);
            core.put("speed", (int) (i < freqs.length ? freqs[i] / 1_000_000 : PROCESSOR.getMaxFreq() / 1_000_000));

            long[] t = i < ticks.length ? ticks[i] : new long[CentralProcessor.TickType.values().length];
            Map<String, Long> times = new LinkedHashMap<>();
            times.put("user", t[CentralProcessor.TickType.USER.getIndex()]);
            times.put("nice", t[CentralProcessor.TickType.NICE.getIndex()]);
            times.put("sys", t[CentralProcessor.TickType.SYSTEM.getIndex()]);
            times.put("idle", t[CentralProcessor.TickType.IDLE.getIndex()]);
            times.put("irq", t[CentralProcessor.TickType.IRQ.getIndex()]);
            core.put("times", times);

            result.add(core);
        }

        return result;
    }

    @Info("JVM free memory (bytes)")
    public long freemem() {
        return Runtime.getRuntime().freeMemory();
    }

    @Info("JVM total memory (bytes)")
    public long totalmem() {
        return Runtime.getRuntime().totalMemory();
    }

    @Info("JVM uptime (seconds)")
    public long uptime() {
        return ManagementFactory.getRuntimeMXBean().getUptime() / 1000;
    }

    @Info("System uptime (seconds)")
    public long systemUptime() {
        return OS.getSystemUptime();
    }

    @Info("System total memory (bytes)")
    public long systemTotalMem() {
        return MEMORY.getTotal();
    }

    @Info("System free memory (bytes)")
    public long systemFreeMem() {
        return MEMORY.getAvailable();
    }

//    @Info("Host name")
//    public String hostname() {
//        try {
//            return InetAddress.getLocalHost().getHostName();
//        } catch (Exception e) {
//            return "unknown";
//        }
//    }

    @Info("OS version")
    public String version() {
        return OS.getVersionInfo().getVersion();
    }

    @Info("OS type")
    public String type() {
        return OS.getFamily();
    }

    @Info("OS build number")
    public String release() {
        return OS.getVersionInfo().getBuildNumber();
    }

    @Info("Available processors (logical)")
    public int availableParallelism() {
        return Runtime.getRuntime().availableProcessors();
    }

    @Info("CPU name")
    public String cpuName() {
        return PROCESSOR.getProcessorIdentifier().getName();
    }

}
