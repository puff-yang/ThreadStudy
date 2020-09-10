package com.vo;

import java.util.List;

/**
 * @ClassName FormatRecordVO
 * @Description
 * @Author ymy
 * @Date 2020-08-28 11:19
 * @Version 1.0
 */
public class FormatRecordVO {
    private Long formatRecordsId;
    private Long questnaireId ;
    private String questnaireName;
    private Long noticeId  ;
    private Long ipsnNo;
    private String ipsnName ;
    private String businessKey ;
    private List<QuestAndAnswerVO> quesList;

    private String quesSeq;
    private String quesName;
    private String quesAnswer;

    public String getQuesSeq() {
        return quesSeq;
    }

    public void setQuesSeq(String quesSeq) {
        this.quesSeq = quesSeq;
    }

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public String getQuesAnswer() {
        return quesAnswer;
    }

    public void setQuesAnswer(String quesAnswer) {
        this.quesAnswer = quesAnswer;
    }

    public List<QuestAndAnswerVO> getQuesList() {
        return quesList;
    }

    public void setQuesList(List<QuestAndAnswerVO> quesList) {
        this.quesList = quesList;
    }

    public Long getFormatRecordsId() {
        return formatRecordsId;
    }

    public void setFormatRecordsId(Long formatRecordsId) {
        this.formatRecordsId = formatRecordsId;
    }

    public Long getQuestnaireId() {
        return questnaireId;
    }

    public void setQuestnaireId(Long questnaireId) {
        this.questnaireId = questnaireId;
    }

    public String getQuestnaireName() {
        return questnaireName;
    }

    public void setQuestnaireName(String questnaireName) {
        this.questnaireName = questnaireName;
    }


    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getIpsnNo() {
        return ipsnNo;
    }

    public void setIpsnNo(Long ipsnNo) {
        this.ipsnNo = ipsnNo;
    }

    public String getIpsnName() {
        return ipsnName;
    }

    public void setIpsnName(String ipsnName) {
        this.ipsnName = ipsnName;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
}
