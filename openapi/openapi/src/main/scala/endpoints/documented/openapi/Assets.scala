package endpoints
package documented
package openapi

/**
  * Interpreter for [[algebra.Assets]]
  */
trait Assets
  extends algebra.Assets
    with Endpoints {

  type AssetRequest = Nothing
  type AssetPath = Nothing
  type AssetResponse = Nothing

  def assetSegments(name: String): Path[AssetPath] =
    DocumentedUrl(s"{$name}", List(DocumentedParameter(name, required = true)), Nil)

  def assetsEndpoint(url: Url[AssetPath], documentation: String, notFoundDocumentation: String): Endpoint[AssetRequest, AssetResponse] =
    endpoint(
      DocumentedRequest(Get, url, emptyHeaders, emptyRequest),
      DocumentedResponse(200, documentation, Map.empty) ::
      DocumentedResponse(404, notFoundDocumentation, Map.empty) ::
      Nil
    )

  def digests: Map[String, String] = Map.empty

}
