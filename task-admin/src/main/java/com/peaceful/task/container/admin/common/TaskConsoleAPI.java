package com.peaceful.task.container.admin.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * task console api list
 *
 * @author WangJun <wangjuntytl@163.com>
 * @version 1.0 15/9/16
 * @since 1.6
 */

public class TaskConsoleAPI {


    private static Logger logger = LoggerFactory.getLogger(TaskConsoleAPI.class);

    public static String cat(String method) {
        try {
            return HttpClient.post("http://" + apiAdd.get() + "?method=" + method);
        } catch (Exception e) {
            logger.error("request found error {}", e);
            return "error";
        }
    }

    public static class Method {

        /**
         * get all focusedTask info
         */
        public final static String focusedTaskBeanSet = "focusedTaskBeanSet";

        /**
         * get all first flexible task info
         */
        public final static String firstFlexibleTaskBeanSet = "firstFlexibleTaskBeanSet";

        /**
         * get all second flexible task info
         */
        public final static String secondFlexibleTaskBeanSet = "secondFlexibleTaskBeanSet";


        /**
         * get task container running info
         */
        public final static String runningInfo = "getRunningInfo";
    }

    /**
     * change console api add on running time
     */
    private static ThreadLocal<String> apiAdd = new ThreadLocal<String>();

    /**
     * Set the API address before invoking it  in the same thread
     *
     * @param add task container api address
     */
    public static void setAdd(String add) {
        apiAdd.set(add);
    }


}
