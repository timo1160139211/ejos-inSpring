/*
 * file_name: AchievementServiceImpl.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月7日 下午8:30:40
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

import site.gaoyisheng.dao.AchievementMapper;
import site.gaoyisheng.pojo.Achievement;
import site.gaoyisheng.service.AchievementService;

@Service("achievementService")
public class AchievementServiceImpl implements AchievementService {

	@Autowired
	private AchievementMapper achievementDao;
	
	@Override
	public Achievement getAchievementByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Achievement> selectAllAchievement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Achievement> selectByStudentId(Integer student_id) {
		return achievementDao.selectByStudentId(student_id);
	}

	@Override
	public List<Achievement> selectByQuestionId(Integer question_id) {
		return achievementDao.selectByQuestionId(question_id);
	}

}
