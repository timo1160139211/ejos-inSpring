/*
 * file_name: UserAchievementForm.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月20日 下午1:29:36
 *       https://www.gaoyisheng.site
 *       https://github.com/timo1160139211
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package site.gaoyisheng.pojo;

import java.io.Serializable;

public class UserAchievementForm implements Serializable{

	private static final long serialVersionUID = -8756245911816080875L;
	Integer student_id;
	String student_number;
	String student_name;

	Integer question_id;
	String question_name;
	String question_introduce;

	Integer teacher_id;
	Integer team_id;
	String team_name;

	Integer achievement_id;
	Integer score;

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getStudent_number() {
		return student_number;
	}

	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_name() {
		return question_name;
	}

	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}

	public String getQuestion_introduce() {
		return question_introduce;
	}

	public void setQuestion_introduce(String question_introduce) {
		this.question_introduce = question_introduce;
	}

	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Integer getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public Integer getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(Integer achievement_id) {
		this.achievement_id = achievement_id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "UserAchievementForm [student_id=" + student_id + ", student_number=" + student_number
				+ ", student_name=" + student_name + ", question_id=" + question_id + ", question_name=" + question_name
				+ ", question_introduce=" + question_introduce + ", teacher_id=" + teacher_id + ", team_id=" + team_id
				+ ", team_name=" + team_name + ", achievement_id=" + achievement_id + ", score=" + score + "]";
	}
}
