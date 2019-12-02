package com.example.demo.service;

import java.util.Map;

public class MetricsDto {

	private int missingFields;
	private int blankContent;
	private int fieldsErrors;
	private Map<String, Integer> originDestination;
	private long RelationshipOK_KO;
	private Map<String, Long> callDuration;
	private Map<String, Integer> rankingWords;
	
	public int getMissingFields() {
		return missingFields;
	}
	public void setMissingFields(int missingFields) {
		this.missingFields = missingFields;
	}
	public int getBlankContent() {
		return blankContent;
	}
	public void setBlankContent(int blankContent) {
		this.blankContent = blankContent;
	}
	public int getFieldsErrors() {
		return fieldsErrors;
	}
	public void setFieldsErrors(int fieldsErrors) {
		this.fieldsErrors = fieldsErrors;
	}
	public Map<String, Integer> getOriginDestination() {
		return originDestination;
	}
	public void setOriginDestination(Map<String, Integer> originDestination) {
		this.originDestination = originDestination;
	}
	public long getRelationshipOK_KO() {
		return RelationshipOK_KO;
	}
	public void setRelationshipOK_KO(long relationshipOK_KO) {
		RelationshipOK_KO = relationshipOK_KO;
	}
	public Map<String, Long> getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(Map<String, Long> callDuration) {
		this.callDuration = callDuration;
	}
	public Map<String, Integer> getRankingWords() {
		return rankingWords;
	}
	public void setRankingWords(Map<String, Integer> rankingWords) {
		this.rankingWords = rankingWords;
	}
	
}
