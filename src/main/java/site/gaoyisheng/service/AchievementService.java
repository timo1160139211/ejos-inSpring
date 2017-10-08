/*
 * file_name: AchievementService.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月7日 下午8:28:04
 *       https://www.gaoyisheng.site
 *       https://github.com/timo1160139211
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package site.gaoyisheng.service;

import java.util.List;

import site.gaoyisheng.pojo.Achievement;

public interface AchievementService {
	public Achievement getAchievementByPrimaryKey(Integer id);

	public List<Achievement> selectAllAchievement();
	public List<Achievement> selectByStudentId(Integer student_id);
	public List<Achievement> selectByQuestionId(Integer question_id);
}
