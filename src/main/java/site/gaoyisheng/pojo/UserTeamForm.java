/*
 * file_name: UserTeamForm.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月15日 下午9:59:50
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

/**
 * .
 * user & team 表单类
 * @author gaoyisheng
 *
 */
public class UserTeamForm {

	Integer student_id;
	String student_number;
	String student_password;
	String student_identity;
	String student_name;
	String student_idcard;
	String student_email;
	Integer team_id;
	String team_name;
	String team_introduce;
	Integer teacher_id;
	
	
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
	public String getStudent_password() {
		return student_password;
	}
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}
	public String getStudent_identity() {
		return student_identity;
	}
	public void setStudent_identity(String student_identity) {
		this.student_identity = student_identity;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_idcard() {
		return student_idcard;
	}
	public void setStudent_idcard(String student_idcard) {
		this.student_idcard = student_idcard;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
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
	public String getTeam_introduce() {
		return team_introduce;
	}
	public void setTeam_introduce(String team_introduce) {
		this.team_introduce = team_introduce;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	@Override
	public String toString() {
		return "UserTeamForm [student_id=" + student_id + ", student_number=" + student_number + ", student_password="
				+ student_password + ", student_identity=" + student_identity + ", student_name=" + student_name
				+ ", student_idcard=" + student_idcard + ", student_email=" + student_email + ", team_id=" + team_id
				+ ", team_name=" + team_name + ", team_introduce=" + team_introduce + ", teacher_id=" + teacher_id
				+ "]";
	}

	
	
}
