package com.shiro.test;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.test
 * @ClassName: Test
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/1 14:13
 * @Version: 1.0
 */
public class Test {
	public static void main(String[] args) {
		ByteSource str=ByteSource.Util.bytes("liufei");
		System.out.println(str);
		String hashAlgorithmName = "MD5";
		String credentials = "123456";
		int hashIterations = 1024;
		ByteSource credentialsSalt = ByteSource.Util.bytes("admin");
		Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
		System.out.println(obj);

	}
}
