/*
 * file_name: MyTest.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年9月28日 下午4:29:27
 *       https://www.gaoyisheng.site
 *       https://github.com/timo1160139211
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package site.gaoyisheng.test;

import org.junit.Before;
import org.junit.Test;

import site.gaoyisheng.dao.UserMapper;
import site.gaoyisheng.dao.UserMapperImpl;
import site.gaoyisheng.pojo.User;

public class MyTest {

	private UserMapper userDao;

	@Before
	public void before() {
		userDao = new UserMapperImpl();
	}

	@Test
	public void testInsert() {
		User user = new User(11,"aNumber","aPassword","teacher","aName","aCard",null,"aEmail");
		userDao.insert(user);
	}
}
