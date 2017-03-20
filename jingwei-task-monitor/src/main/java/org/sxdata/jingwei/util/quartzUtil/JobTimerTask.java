package org.sxdata.jingwei.util.quartzUtil;

import org.pentaho.di.core.Const;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sxdata.jingwei.util.TaskUtil.CarteClient;
import org.sxdata.jingwei.entity.SlaveEntity;
import org.sxdata.jingwei.entity.UserEntity;
import org.sxdata.jingwei.util.TaskUtil.CarteTaskManager;

/**
 * Created by cRAZY on 2017/3/6.
 * 定时作业具体方法 by quartz
 */
public class JobTimerTask implements Job{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String path = context.getJobDetail().getJobDataMap().getString("jobFullPath");
        SlaveEntity slave=(SlaveEntity)context.getJobDetail().getJobDataMap().get("slave");
        UserEntity user=(UserEntity)context.getJobDetail().getJobDataMap().get("loginUser");
        try {
            CarteClient cc=new CarteClient(slave);
            //拼接资源库名
            String repoId=CarteClient.hostName+"_"+CarteClient.databaseName;
            //节点执行作业的请求
            String urlString="/?rep="+repoId+"&user="+user.getLogin()+"&pass="+user.getPassword()+"&job="+path+"&level=Basic";
            urlString = Const.replace(urlString, "/", "%2F");
            urlString = cc.getHttpUrl() + CarteClient.EXECREMOTE_JOB +urlString;
            System.out.println("定时作业请求的url字符串为" + urlString);
            CarteTaskManager.addTask(cc, "job_exec", urlString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}