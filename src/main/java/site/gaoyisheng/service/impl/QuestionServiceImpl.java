/*
 * file_name: QuestionServiceImpl.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月7日 下午7:15:09
 *       https://www.gaoyisheng.site
 *       https://github.com/timo1160139211
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package site.gaoyisheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.gaoyisheng.dao.QuestionMapper;
import site.gaoyisheng.pojo.Question;
import site.gaoyisheng.service.QuestionService;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper questionDao;

	@Override
	public Question getQuestionByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> selectByTeamId(Integer team_id) {
		return questionDao.selectByTeamId(team_id);
	}

}
