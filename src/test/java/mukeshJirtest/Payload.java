package mukeshJirtest;

public class Payload {

	String 	summary;
	String description;
	Project project;
		Issuename issue;
		
		public Payload(String summary,String description,Project project,Issuename issue) {
			this.summary = summary;
			this.description = description;
			this.project = project;
			this.issue = issue;
			
		}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Issuename getIssue() {
		return issue;
	}
	public void setIssue(Issuename issue) {
		this.issue = issue;
	}
	
}

