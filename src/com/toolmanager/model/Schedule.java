package com.toolmanager.model;

import java.util.Calendar;

public class Schedule {
	private Long id_schedule;
	private String name;
	private String description;
	private Calendar date_started;
	private Calendar date_finished;
	
	public Schedule() {}
	/**
	 * @param name
	 * @param description
	 * @param date_started
	 * @param date_finished
	 */
	public Schedule(String name, String description, Calendar date_started,
			Calendar date_finished) {
		super();
		this.name = name;
		this.description = description;
		this.date_started = date_started;
		this.date_finished = date_finished;
	}
	public Long getId_schedule() {
		return id_schedule;
	}
	public void setId_schedule(Long id_schedule) {
		this.id_schedule = id_schedule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Calendar getDate_started() {
		return date_started;
	}
	public void setDate_started(Calendar date_started) {
		this.date_started = date_started;
	}
	public Calendar getDate_finished() {
		return date_finished;
	}
	public void setDate_finished(Calendar date_finished) {
		this.date_finished = date_finished;
	}
	@Override
	public String toString() {
		return "Schedule [id_schedule=" + id_schedule + ", name=" + name
				+ ", description=" + description + ", date_started="
				+ date_started + ", date_finished=" + date_finished + "]";
	}
}
