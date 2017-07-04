package com.roc.service;/**
 * Created by WanPengCheng on 2017/7/4.
 */

import com.roc.provider.ISysProvider;
import com.roc.provider.SysProviderImpl;
import org.springframework.stereotype.Service;

/**
 * @author WanPengCheng
 * @create 2017-07-04-14:24
 **/
@Service("sysProvider")
public class BaseSysProviderImpl extends SysProviderImpl implements ISysProvider {

}
