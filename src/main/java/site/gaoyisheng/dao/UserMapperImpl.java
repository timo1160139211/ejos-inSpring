/*
 * file_name: UserMapperImpl.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年9月28日 下午4:36:39
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
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import site.gaoyisheng.pojo.User;

public class UserMapperImpl implements UserMapper {

	private SqlSession sqlSession;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			sqlSession.delete("deleteByPrimaryKey", id);
			
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return 0;
	}

	@Override
	public int insert(User user) {
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			sqlSession.insert("insertSelective", user);

			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return 0;
	}
	
	@Override
	public	int insertCacheId(User user){
		int i = 0;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			i = sqlSession.insert("insertCacheId", user);

			sqlSession.commit();
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
	public List<User> selectAllUser() {
		List<User> userList = null;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			userList = sqlSession.selectList("selectAllUser");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return userList;
	}

	@Override
	public List<User> selectAllUserByIdentity(String identity) {
		List<User> userList = null;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			userList = sqlSession.selectList("selectAllUserByIdentity", identity);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return userList;
	}
	
	@Override
	public List<User> selectAllUserExceptIdentity(String identity) {
		List<User> userList = null;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			userList = sqlSession.selectList("selectAllUserExceptIdentity", identity);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return userList;
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectByNumberAndPassword(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User user) {
		int i = 0;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			i = sqlSession.update("updateByPrimaryKeySelective", user);

			sqlSession.commit();
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
