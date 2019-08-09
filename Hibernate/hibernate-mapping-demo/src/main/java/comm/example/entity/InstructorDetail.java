package comm.example.entity;

	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "instructor_detail")
	public class InstructorDetail implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name = "youtube_channel")
		private String youtubeChannel;
		private String hobby;
		
		public InstructorDetail() {
			super();
		}
		
		public InstructorDetail(int id, String youtubeChannel, String hobby) {
			super();
			this.id = id;
			this.youtubeChannel = youtubeChannel;
			this.hobby = hobby;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getYoutubeChannel() {
			return youtubeChannel;
		}
		public void setYoutubeChannel(String youtubeChannel) {
			this.youtubeChannel = youtubeChannel;
		}
		public String getHobby() {
			return hobby;
		}

		public void setHobby(String hobby) {
			this.hobby = hobby;
		}

		

}
