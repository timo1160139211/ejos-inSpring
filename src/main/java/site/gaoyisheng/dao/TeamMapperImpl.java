/*
 * file_name: TeamMapperImpl.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月8日 下午12:21:35
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

import site.gaoyisheng.pojo.Team;

public class TeamMapperImpl implements TeamMapper {
	
	private SqlSession sqlSession;

	@Override
	public List<Team> selectByTeacherId(Integer teacherId) {
		List<Team> teamList = null;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			teamList = sqlSession.selectList("selectByTeacherId",teacherId);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return teamList;
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		int i = 0;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			i = sqlSession.delete("deleteByPrimaryKey",id);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return i;
	}

	@Override
	public int insert(Team record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Team record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Team selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Team team) {
		int i = 0;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			i = sqlSession.update("updateByPrimaryKeySelective",team);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return i;
	}

	@Override
	public int updateByPrimaryKey(Team team) {
		
		return 0;
	}

	@Override
	public int insertCacheId(Team team) {
		int i = 0;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			i = sqlSession.insert("insertCacheId",team);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return i;
	}



}
