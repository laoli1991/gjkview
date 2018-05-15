package com.gjk.view;

import javax.swing.JLabel;

/**
 * @Author: liyang117
 * @Date: 2018/4/27 21:37
 * @Description:
 */
public class ConfigStaticDatas {
    public static JLabel voucherName = new JLabel();
    public static JLabel typeDesc = new JLabel();
    public static JLabel nowTime = new JLabel();
    public static JLabel amount = new JLabel();
    public static JLabel key1 = new JLabel();
    public static JLabel value1 = new JLabel();
    public static JLabel key2 = new JLabel();
    public static JLabel value2 = new JLabel();
    public static JLabel commonInfo = new JLabel();
    public static MsgDto msgDtoBegin = new MsgDto();

    public static void freshJLabels(MsgDto msgDto) {
        if (msgDto == null) {
            return;
        }
        ConfigStaticDatas.amount.setText(AppUtils.formtStr(msgDto.getAmount()));
        ConfigStaticDatas.commonInfo.setText(AppUtils.formtStr(msgDto.getCommonInfo()));
        ConfigStaticDatas.key1.setText(AppUtils.formtStr(msgDto.getKey1()));
        ConfigStaticDatas.key2.setText(AppUtils.formtStr(msgDto.getKey2()));
        ConfigStaticDatas.nowTime.setText(AppUtils.formtStr(msgDto.getNowTime()) + "更新");
        ConfigStaticDatas.typeDesc.setText(AppUtils.formtStr(msgDto.getTypeDesc()));
        ConfigStaticDatas.value1.setText(AppUtils.formtStr(msgDto.getValue1()));
        ConfigStaticDatas.value2.setText(AppUtils.formtStr(msgDto.getValue2()));
        ConfigStaticDatas.voucherName.setText(AppUtils.formtStr(msgDto.getVoucherName()));
    }
}
