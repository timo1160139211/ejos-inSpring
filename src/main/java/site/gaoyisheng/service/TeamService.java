/*
 * file_name: TeamService.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月11日 下午7:04:01
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

import site.gaoyisheng.pojo.Team;

public interface TeamService {

	List<Team> selectByTeacherId(Integer teacherId);
	
	int insertCacheId(Team team);

	int deleteByPrimaryKey(Integer id);

	Team selectByPrimaryKey(Integer teamId);

	int updateByPrimaryKeySelective(Team team);
}
