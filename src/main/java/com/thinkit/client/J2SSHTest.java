/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkit.client;

/**
 * RUN Luck Man
 *
 * @author qiaokai
 * @date 2013-11-12 11:03:42
 */
import com.sshtools.j2ssh.ScpClient;
import com.sshtools.j2ssh.SshClient;
import java.io.OutputStream;

import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.session.SessionChannelClient;
import com.sshtools.j2ssh.transport.HostKeyVerification;
import com.sshtools.j2ssh.transport.TransportProtocolException;
import com.sshtools.j2ssh.transport.publickey.SshPublicKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2SSHTest {
    private static Object lock = new Object();
    public static   void main(String[] args) {
        //ִ��cmd
        runCmd();
        
    }
    
    public static  synchronized  void runCmd(){
        SshClient ssh = new SshClient();
        PasswordAuthenticationClient authentication = new PasswordAuthenticationClient();
        authentication.setUsername("thinkit");
        authentication.setPassword("TBNR$0987");
        try {
//            ssh.connect("192.168.94.254", 22, new HostsKeyVerification());
            ssh.connect("192.168.14.213", 22,new HostKeyVerification(){
                @Override
                public boolean verifyHost(String arg0, SshPublicKey arg1)
                                throws TransportProtocolException {
                        // TODO Auto-generated method stub
                        return true;
                }});
            if (ssh.authenticate(authentication) == AuthenticationProtocolState.COMPLETE) {
                
                
//                ScpClient scp =ssh.openScpClient();
               
                SessionChannelClient session = ssh.openSessionChannel();
                
                // session.setEnvironmentVariable("TERM", "linux");
                // if (client.requestPseudoTerminal("vt100", 120, 400, 0, 0,
                // "")) {
//               session.executeCommand("bash -c");
//                session.executeCommand("cd /home/thinkit/huawei_test;sh hwrun.sh /home/thinkit/huawei_voice/v3 /home/thinkit/huawei_voice/r3 /home/thinkit/huawei_voice/v3.list");
//               session.executeCommand("pwd;ls -al");
                session.executeCommand("pwd;cd /home/thinkit/huawei_test;sh hwrun.sh /home/thinkit/huawei_voice/v8 /home/thinkit/huawei_voice/r8 /home/thinkit/huawei_voice/v8.list");
              
                BufferedReader in = new BufferedReader(new InputStreamReader(session.getInputStream()));
                BufferedReader err = new BufferedReader(new InputStreamReader(session.getStderrInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("------------------------");
                while ((line = err.readLine()) != null) {
                    System.out.println(line);
                }
                if (session != null) {
                    session.close();
                }


//                if (session.startShell()) {
//                    OutputStream writer = session.getOutputStream();
//                    writer.write("echo $?\n".getBytes());
//                    writer.flush();
//                    writer.write("exit\n".getBytes());
//                    writer.flush();
//                    BufferedReader in = new BufferedReader( new InputStreamReader(session.getInputStream()));
//                    BufferedReader err = new BufferedReader(new InputStreamReader(session.getStderrInputStream()));
//                    String line;
//                    while ((line = in.readLine()) != null) {
//                        System.out.println(line);
//                    }
//                    System.out.println("------------------------");
//                    while ((line = err.readLine()) != null) {
//                        System.out.println(line);
//                    }
//                    if (session != null) {
//                        session.close();
//                    }
//                }
                // }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
