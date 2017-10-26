/*
 * file_name: CachingConfig.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2017年10月25日 上午11:50:33
 *       https://www.gaoyisheng.site
 *       https://github.com/timo1160139211
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package site.gaoyisheng.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class CachingConfig {

	@SuppressWarnings("rawtypes")
	@Bean
	public CacheManager cacheManager(RedisTemplate rt) {
		System.out.println("****cacheManager" + ": i am invoked- 0 0 - - 0 0 - -");
		return new RedisCacheManager(rt);
	}

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("127.0.0.1");
		jedisConnectionFactory.setPort(6379);
		jedisConnectionFactory.afterPropertiesSet();

		return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisCF) {

		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(redisCF);
		redisTemplate.afterPropertiesSet();

		return redisTemplate;
	}
}
