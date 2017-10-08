/*
 * file_name: QuestionMapperImpl.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月7日 下午7:07:13
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

import site.gaoyisheng.pojo.Question;
import site.gaoyisheng.pojo.User;

public class QuestionMapperImpl implements QuestionMapper {
	
	private SqlSession sqlSession;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Question record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Question record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Question selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> selectByTeamId(Integer team_id) {
		List<Question> questionList = null;
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("spring-mybatis.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 4.参数是(sql语句id , Object对象)
			questionList = sqlSession.selectList("selectByTeamId", team_id);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return questionList;
	}

	@Override
	public int updateByPrimaryKeySelective(Question record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Question record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
