/*
 * file_name: TeamServiceImpl.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月11日 下午7:42:18
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

import site.gaoyisheng.dao.TeamMapper;
import site.gaoyisheng.pojo.Team;
import site.gaoyisheng.service.TeamService;

@Service("teamService")
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamMapper teamDao;
	
	@Override
	public List<Team> selectByTeacherId(Integer teacherId) {
		return teamDao.selectByTeacherId(teacherId);
	}

	@Override
	public int insertCacheId(Team team) {
		return teamDao.insertCacheId(team);
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return this.teamDao.deleteByPrimaryKey(id);
	}

	@Override
	public Team selectByPrimaryKey(Integer teamId) {
		return this.teamDao.selectByPrimaryKey(teamId);
	}

	@Override
	public int updateByPrimaryKeySelective(Team team) {
		return this.teamDao.updateByPrimaryKeySelective(team);
	}
}
