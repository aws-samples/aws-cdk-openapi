package aws.sample.blog.cdkopenapi.cdk;

import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.Stage;
import software.amazon.awscdk.StageProps;
import software.constructs.Construct;

public class ApiStackStage extends Stage {

	public ApiStackStage(final Construct scope, final String id) {
		this(scope, id, null);
	}

	public ApiStackStage(final Construct scope, final String id, final StageProps props) {
		super(scope, id, props);

		new ApiStack(this, "OpenAPIBlogAPI", id, StackProps.builder().build());

	}

}
