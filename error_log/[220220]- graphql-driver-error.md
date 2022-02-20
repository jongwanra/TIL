## Occured Error

ERROR [GraphQLModule] Missing "driver" option. In the latest version of "@nestjs/graphql" package (v10) a new required configuration property called "driver" has been introduced. Check out the official documentation for more details on how to migrate (https://docs.nestjs.com/graphql/migration-guide).

## Solution


```javascript
import { Module } from '@nestjs/common';
import { GraphQLModule } from '@nestjs/graphql';
import { ApolloDriver, ApolloDriverConfig } from '@nestjs/apollo';

@Module({
  imports: [
    GraphQLModule.forRoot<ApolloDriverConfig>({
      driver: ApolloDriver,
    }),
  ],
})
export class AppModule {}
```

- ApploDriver, ApploDriverConfig를 추가해 주면 된다.

## Reference

- https://docs.nestjs.com/graphql/quick-start
