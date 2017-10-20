/*
 * file_name: TeacherOpsController.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月9日 上午10:33:27
 *       https://www.gaoyisheng.site
 *       https://github.com/timo1160139211
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package site.gaoyisheng.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import site.gaoyisheng.pojo.Team;
import site.gaoyisheng.pojo.User;
import site.gaoyisheng.pojo.UserTeamForm;
import site.gaoyisheng.service.TeamService;
import site.gaoyisheng.service.UserService;

@Controller
@RequestMapping("/teacher")
public class TeacherOpsController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TeamService teamService;
	
	
	@RequestMapping("/home")
	public ModelAndView home(HttpSession session) {
		
		User currentUser =(User) session.getAttribute("currentUser");
		System.out.println("home:" + currentUser.toString());
		
		if(!currentUser.getIdentity().equals("teacher")) {}//如果currentUser 不是teacher
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("currentUser",currentUser)
		  .setViewName("/" + currentUser.getIdentity() + "/home");
		
		return mv;
	}
	
	/******************************************TEAM***********************************************/
	@RequestMapping("/team-list")
	public ModelAndView teamList(HttpSession session) {
		
		User currentUser =(User) session.getAttribute("currentUser");
		
		List<Team> teamList = teamService.selectByTeacherId(currentUser.getId());

		ModelAndView mv = new ModelAndView();
		mv.addObject("teamList",teamList)
		  .addObject("currentUser", currentUser)
		  .setViewName("/teacher/team-list");
		
		return mv;
	}
	
	@RequestMapping("/team-add-form")
	public ModelAndView addTeamForm(HttpSession session) {
		
		User currentUser =(User) session.getAttribute("currentUser");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("team", new Team())
		  .setViewName("/" + currentUser.getIdentity() +"/team-add-form");
		
		return mv;
	}
	
	@RequestMapping("/team-add")
	public ModelAndView addTeam(@ModelAttribute Team team,HttpSession session) {
		
		User currentTeacher =(User) session.getAttribute("currentUser");
		
		team.setTeacherId(currentTeacher.getId());
		teamService.insertCacheId(team);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:" + "/teacher/team-list");
		
		return mv;
	}
	
	@RequestMapping("/team-delete/{teamId}")
	public ModelAndView deleteTeam(@PathVariable("teamId") Integer teamId) {
		
		teamService.deleteByPrimaryKey(teamId);
		
		ModelAndView mv = new ModelAndView("redirect:" + "/teacher/team-list");
		
		return mv;
	}
	
	@RequestMapping("/team-update-form/{teamId}")
	public ModelAndView updateTeamForm(@PathVariable("teamId") Integer teamId) {
		
		Team team = teamService.selectByPrimaryKey(teamId);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("selectedTeam", team)
		  .setViewName("/teacher/team-update-form");
		
		return mv;
	}
	
	@RequestMapping("/team-update")
	public ModelAndView updateTeam(@ModelAttribute Team team) {
		
		teamService.updateByPrimaryKeySelective(team);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:" + "/teacher/team-list");
		
		return mv;
	}
	
	/******************************************TEAM***********************************************/
	
	/******************************************STUDENT********************************************/
	@RequestMapping("/student-list")
	public ModelAndView studentList(HttpSession session,
			                         @RequestParam(name="teamId",required=false)Integer teamId) {
		
		User currentUser =(User) session.getAttribute("currentUser");

		List<Team> teams = teamService.selectByTeacherId(currentUser.getId());
		
		List<UserTeamForm> userTeamFormModels = userService.selectByTeacherIdAndTeamId(currentUser.getId(), teamId);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userTeamFormModels",userTeamFormModels)
		  .addObject("currentUser", currentUser)
		  .addObject("teams", teams)
		  .setViewName("/teacher/student-list");
		
		return mv;
	}
	
	@RequestMapping("/student-add-form")
	public ModelAndView addSudentForm(HttpSession session) {
		
		User currentUser =(User) session.getAttribute("currentUser");
		
		List<Team> teams = teamService.selectByTeacherId(currentUser.getId());
		ModelAndView mv = new ModelAndView();
		mv.addObject("student", new User())
		  .addObject("teams", teams)
		  .setViewName("/teacher/student-add-form");
		
		return mv;
	}
	
	@RequestMapping("/student-add")
	public ModelAndView addStudent(@ModelAttribute User student) {
		
		student.setIdentity("student");
		userService.insertCacheId(student);
		
		ModelAndView mv = new ModelAndView("redirect:" + "/teacher/student-list");
		
		return mv;
	}
	
	@RequestMapping("/student-delete/{studentId}")
	public ModelAndView deleteStudent(@PathVariable("studentId") Integer studentId) {
		
		userService.deleteByPrimaryKey(studentId);
		
		ModelAndView mv = new ModelAndView("redirect:" + "/teacher/student-list");
		
		return mv;
	}
	
	@RequestMapping("/student-update-form/{studentId}")
	public ModelAndView updateStudentForm(@PathVariable("studentId") Integer studentId,HttpSession session) {
		User currentUser =(User) session.getAttribute("currentUser");

		
		User selectedStudent = userService.selectUserByPrimaryKey(studentId);
		List<Team> teams = teamService.selectByTeacherId(currentUser.getId());

		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("selectedStudent", selectedStudent)
		  .addObject("teams", teams)
		  .setViewName("/teacher/student-update-form");
		
		return mv;
	}
	
	@RequestMapping("/student-update")
	public ModelAndView updateStudent(@ModelAttribute User student) {
		
		userService.updateByPrimaryKeySelective(student);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:" + "/teacher/student-list");
		
		return mv;
	}
	
	/******************************************STUDENT********************************************/
	
	/******************************************QUESTION********************************************/
	
	
	
	
	
	
	/******************************************QUESTION********************************************/

	/******************************************ACHIEVEMENT********************************************/
	
	@RequestMapping("/achievement-list")
	public ModelAndView achievementList(HttpSession session) {
		
		User currentUser =(User) session.getAttribute("currentUser");

		List<Team> teams = teamService.selectByTeacherId(currentUser.getId());
		
		List<User> studentList = new ArrayList<User>();
		
		for(Team team:teams) {
			studentList.addAll(userService.selectByTeamId(team.getId()));
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("achievementList",studentList)
		  .addObject("currentUser", currentUser)
		  .setViewName("/teacher/achievement-list");
		
		return mv;
	}	
	
	/******************************************ACHIEVEMENT********************************************/

}
