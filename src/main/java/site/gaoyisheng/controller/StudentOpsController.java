/*
 * file_name: StudentOpsController.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月8日 下午6:46:04
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


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import site.gaoyisheng.pojo.Question;
import site.gaoyisheng.pojo.User;
import site.gaoyisheng.service.QuestionService;

@Controller
@RequestMapping("/student")
@SessionAttributes(types = { User.class }) // 设置会话属性
public class StudentOpsController {

	@Autowired
	private QuestionService qs;
	
	@RequestMapping("/home")
	public ModelAndView home(HttpSession session) {
		
		User currentUser =(User) session.getAttribute("currentUser");
		System.out.println("home:" + currentUser.toString());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("currentUser",currentUser)
		  .setViewName("/student/home");
		
		return mv;
	}
	
	@RequestMapping("/questionList")
	public ModelAndView questionList(HttpSession session) {
		
		User currentUser =(User) session.getAttribute("currentUser");
		System.out.println("questionList:" + currentUser.toString());
		
		List<Question> questionList = qs.selectByTeamId(currentUser.getTeamId());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("questionList",questionList)
		  .setViewName("/student/questionList");
		
		return mv;
	}
	
	@RequestMapping("/exam/{questionId}")
	public ModelAndView exam(HttpSession session,@PathVariable("questionId") Integer questionId) {
		
		User currentUser =(User) session.getAttribute("currentUser");
		System.out.println("questionList:" + currentUser.toString());
		System.out.println(questionId);
		
		List<Question> questionList = qs.selectByTeamId(currentUser.getTeamId());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("questionList",questionList)
		  .addObject("currentUser",currentUser)
		  .setViewName("/student/exam");
		
		return mv;
	}
	
}
