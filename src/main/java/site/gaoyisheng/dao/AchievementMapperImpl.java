/*
 * file_name: AchievementMapperImpl.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月7日 下午8:33:27
 *       https://www.gaoyisheng.site
 *       https://github.com/timo1160139211
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package site.gaoyisheng.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import site.gaoyisheng.pojo.Achievement;

public class AchievementMapperImpl implements AchievementMapper {

	private SqlSession sqlSession;

	@Override
	public List<Achievement> selectByStudentId(Integer student_id) {
		List<Achievement> achievementList = null;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			achievementList = sqlSession.selectList("selectByStudentId", student_id);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return achievementList;
	}

	@Override
	public List<Achievement> selectByQuestionId(Integer question_id) {
		List<Achievement> achievementList = null;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			achievementList = sqlSession.selectList("selectByQuestionId", question_id);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return achievementList;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Achievement record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Achievement record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Achievement selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Achievement record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Achievement record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
