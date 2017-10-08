/*
 * file_name: QuestionService.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月7日 下午7:12:55
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

import site.gaoyisheng.pojo.Question;

public interface QuestionService {
	public Question getQuestionByPrimaryKey(Integer id);

	public List<Question> selectAllUser();
	public List<Question> selectByTeamId(Integer team_id);
	
}
