import com.tkisor.utiljs.kubejs.Os;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class OsTest {
    private final Os os = new Os();

    @Test
    void printAllOsInfo() {
        System.out.println("=== OS 信息收集 ===");
        System.out.println("EOL: [" + os.EOL.replace("\n", "\\n").replace("\r", "\\r") + "]");
        System.out.println("Platform: " + os.platform());
        System.out.println("Arch: " + os.arch());
        System.out.println("Free Memory: " + os.freemem() + " bytes");
        System.out.println("Total Memory: " + os.totalmem() + " bytes");
        System.out.println("Uptime: " + os.uptime() + " seconds");
        System.out.println("System Uptime: " + os.systemUptime() + " seconds");
        System.out.println("System Free Memory: " + os.systemFreeMem() + " bytes");
        System.out.println("System Total Memory: " + os.systemTotalMem() + " bytes");
//        System.out.println("Hostname: " + os.hostname());
        System.out.println("OS Version: " + os.version());
        System.out.println("OS Type: " + os.type());
        System.out.println("OS Release: " + os.release());
        System.out.println("Available Parallelism (Cores): " + os.availableParallelism());
        System.out.println("CPU Name: " + os.cpuName());

        // 测试CPU核心信息
        System.out.println("\nCPU Cores Information:");
        List<Map<String, Object>> cpus = os.cpus();
        System.out.println("Number of logical processors: " + cpus.size());
        if (!cpus.isEmpty()) {
            Map<String, Object> firstCore = cpus.get(0);
            System.out.println("First CPU Core:");
            System.out.println("  Model: " + firstCore.get("model"));
            System.out.println("  Speed: " + firstCore.get("speed") + " MHz");

            @SuppressWarnings("unchecked")
            Map<String, Long> times = (Map<String, Long>) firstCore.get("times");
            System.out.println("  CPU Times:");
            System.out.println("    User: " + times.get("user"));
            System.out.println("    Nice: " + times.get("nice"));
            System.out.println("    System: " + times.get("sys"));
            System.out.println("    Idle: " + times.get("idle"));
            System.out.println("    IRQ: " + times.get("irq"));
        }

        System.out.println("====================");
    }
}
