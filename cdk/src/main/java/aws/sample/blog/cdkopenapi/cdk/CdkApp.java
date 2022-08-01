package aws.sample.blog.cdkopenapi.cdk;

import software.amazon.awscdk.App;

public class CdkApp {
    public static void main(final String[] args) {
        App app = new App();
    
        String repositoryString = app.getNode().tryGetContext("RepositoryString").toString();
        String repositoryBranch = app.getNode().tryGetContext("RepositoryBranch").toString();
        String codestarConnectionArn = app.getNode().tryGetContext("CodestarConnectionArn").toString();
        String codeArtifactDomain = app.getNode().tryGetContext("CodeArtifactDomain").toString();
        String codeArtifactRepository = app.getNode().tryGetContext("CodeArtifactRepository").toString();
        
        
        //new ApiStack(app,"OpenAPIBlogAPIStack", "DEV", StackProps.builder().build());

        new PipelineStack(app, "OpenAPIBlogPipeline", repositoryString, repositoryBranch, codestarConnectionArn,
        		codeArtifactRepository, codeArtifactDomain);
        
        app.synth();
    }
}

